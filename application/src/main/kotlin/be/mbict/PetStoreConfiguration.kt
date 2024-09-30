package be.mbict

import be.mbict.petstore.PetApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class PetStoreConfiguration {

    @Bean
    internal fun apiClient(builder: RestClient.Builder) = ApiClient(builder.build()).setBasePath("https://petstore.swagger.io:443/v2")

    @Bean
    internal fun petApi(apiClient: ApiClient) = PetApi(apiClient)
}