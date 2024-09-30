package be.mbict

import be.mbict.petstore.Pet.StatusEnum
import be.mbict.petstore.PetApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class PetController(private val petApi: PetApi) {

    @GetMapping
    fun allAvailablePets() =
        petApi.findPetsByStatus(listOf(StatusEnum.AVAILABLE.value))
}