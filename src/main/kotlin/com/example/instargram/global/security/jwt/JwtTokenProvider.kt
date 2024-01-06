package com.example.instargram.global.security.jwt

import com.example.instargram.global.security.exception.ExpiredTokenException
import com.example.instargram.global.security.exception.InvalidJwtException
import com.example.instargram.global.security.jwt.dto.TokenResponse
import com.example.instargram.global.security.jwt.entity.RefreshToken
import com.example.instargram.global.security.jwt.repository.RefreshTokenRepository
import com.example.instargram.global.security.principle.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.Date
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
) {
    fun getToken(info: String): TokenResponse {
        val accessToken: String = generateAccessToken(info, jwtProperties.accessExp)
        return TokenResponse(accessToken = accessToken)
    }

    private fun generateAccessToken(info: String, expiration: Long): String {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .setSubject(info)
            .setHeaderParam("typ", "access")
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .compact()
    }


    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader("Authorization")

        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "")
        } else null
    }

    fun authorization(token: String): UsernamePasswordAuthenticationToken {
        return token.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getTokenSubject(subject: String): String {
        return getTokenBody(subject).subject
    }

    private fun getTokenBody(token: String?): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secret)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException
                is InvalidClaimException -> throw InvalidJwtException
                else -> throw InvalidJwtException
            }
        }
    }
}
