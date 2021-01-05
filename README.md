# Top Pokemon

### Description
This is a Pokemon finder application implemented half as a knowledge test and half just for fun.

### Requisites

We want to show in JSON via HTTP's request the following scenarios:

1. The 5 heaviest Pokémons.
2. The 5 highest Pokémons.
3. The 5 Pokémons with more base experience.

To know this information, you must create a platform based on microservices with the following prerequisites:

- Use Java/SpringBoot
- JUnit Tests
- Use PokéAPI: https://pokeapi.co/api/v2/
- We only want Pokémons of "red version". You can find this information on the section "game_indices" for each Pokémon:
    - version_name = "red"
    - version_url = "https://pokeapi.co/api/v2/version/1/"

It will be valued positively:
- Clean Code
- Code Quality
- Environment running in Dockers
- SOLID Principles
- Design Patterns

Our recommendations:
- https://start.spring.io/
- Project Lombok
- h2database