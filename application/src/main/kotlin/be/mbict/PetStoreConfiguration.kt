package be.mbict

import be.mbict.petstore.apis.PetApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient

@Configuration
class PetStoreConfiguration {

    @Bean
    internal fun petApi(builder: RestClient.Builder) = PetApi(builder
        .baseUrl("https://petstore.swagger.io:443/v2")
        .requestInterceptor { request, body, execution ->
            request.headers.accept = listOf(MediaType.APPLICATION_JSON)
            execution.execute(request, body)
        }
        .build())
}