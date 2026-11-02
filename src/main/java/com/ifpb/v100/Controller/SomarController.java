import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/somar")
public class SomarController {

    @PostMapping
    public ResponseEntity<SomarResponseDTO> somar(@Valid @RequestBody SomarRequestDTO request) {
        //o contrato aceita inteiros, decimais e negativos.
        Double resultado = request.getA() + request.getB();
        
        SomarResponseDTO response = new SomarResponseDTO();
        response.setResultado(resultado);
        
        return ResponseEntity.ok(response);
    }
}