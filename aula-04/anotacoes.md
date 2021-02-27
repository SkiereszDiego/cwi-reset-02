`@RestController`

   * Deve ser usado no nível da classe
   * Serve para indicar que a classe é uma Controller
   * Não precisa informar parâmetros
   * Exemplos
     - `@RestController public class FilmeController {` 

`@RequestMapping`
   * Pode ser usada em nível de classe e de método
   * Serve para definir qual é a rota da classe ou método onde for usado.
   * Exemplos:
     - `@RequestMapping("/filmes")`

`@PostMapping`
   - Deve ser usado em nível de método
   - Serve para indicar qual é o método HTTP que o método vai atender. Neste caso, o POST
   - Poder ter parâmetros. Se houver, vai indicar qual a rota a que atende. Caso seja suprimido, vai ser adotada a rota da classe.
   - Exemplos:
     - `@PostMapping` 
     - `@PostMapping("/series")` 

`@GetMapping`
   - Deve ser usado em nível de método
   - Serve para indicar qual é o método HTTP que o método vai atender. Neste caso, o GET
   - Poder ter parâmetros. Se houver, vai indicar qual a rota a que atende. Caso seja suprimido, vai ser adotada a rota da classe.
   - Exemplos:
     - `@GetMapping` 
     - `@GetMapping("/{id}")` 
     - `@GetMapping("/{id}/premiacoes")` 

`@PutMapping`
   - Deve ser usado em nível de método
   - Serve para indicar qual é o método HTTP que o método vai atender. Neste caso, o PUT
   - Poder ter parâmetros. Se houver, vai indicar qual a rota a que atende. Caso seja suprimido, vai ser adotada a rota da classe.
   - Exemplos:
     - `@PutMapping` 
     - `@PutMapping("/{id}")` 

`@DeleteMapping`
   - Deve ser usado em nível de método
   - Serve para indicar qual é o método HTTP que o método vai atender. Neste caso, o DELETE
   - Poder ter parâmetros. Se houver, vai indicar qual a rota a que atende. Caso seja suprimido, vai ser adotada a rota da classe.
   - Exemplos:
     - `@DeleteMapping` 
     - `@DeleteMapping("/{id}")` 

`@RequestBody`
   - Deve ser usado no nível de parâmetro 
   - Serve para indicar que o objeto anotado corresponde ao body da requisição. O Spring vai tentar converter o body recebido neste objeto. Ele já vai instanciar o objeto com os dados do body.
   - Exemplos
     - `public Filme cadastrar(@RequestBody FilmeRequest request) {`

`@Autowired`
   - Deve ser usado em nível de atributos
   - Serve para injetar uma instância da classe anotada. O Spring será responsável for criar a instância e atribuir à variavel anotada.
   - Exemplos
     - `@Autowired private FilmeService filmeService;` 
    
`@Service`
   - Deve ser usado no nível da classe
   - Serve apenas para indicar que é um componente que deve ser gerenciado pelo Spring. Com essa anotação, garantimos que o Spring poderá injetar essa classe em outra através do `@Autowired`
   - É semelhante ao `@Repository`, porém é usado para indicar que esta classe possui as regras de negócio
   - Exemplos
     - `@Service public class ListarFilmeService {` 

`@Repository`
   - Deve ser usado no nível da classe
   - Serve apenas para indicar que é um componente que deve ser gerenciado pelo Spring. Com essa anotação, garantimos que o Spring poderá injetar essa classe em outra através do `@Autowired`
   - É semelhante ao `@Service`, porém é usado para indicar que esta classe possui o acesso à fonte de dados
   - Exemplos
     - `@Repository public class FilmeRepository {` 

`@ApiIgnore`
   - Deve ser usado no nível de parâmetro 
   - Serve apenas para indicar ao Swagger para ignorar algum parâmetro na hora de montar o Swagger UI

`@ResponseStatus`
   - Pode ser usada em nível de classe e de método
   - Serve para indicar qual o HTTP Status que a classe ou o método deve retornar POR PADRÃO.
   - Exemplos
     - `@ResponseStatus(HttpStatus.NOT_FOUND)` 

