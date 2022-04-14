
package mx.com.gm;

import mx.com.gm.api.IdentificarAdn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostAdn {
     
    @PostMapping("/postAdn")
    public ResponseEntity<Boolean> prueba(@RequestBody IdentificarAdn adn) {
      if(adn.hasMutation(adn.getDna()) == true){
          return new ResponseEntity<Boolean>(adn.hasMutation(adn.getDna()),HttpStatus.OK);
      }else{
          return new ResponseEntity<Boolean>(adn.hasMutation(adn.getDna()),HttpStatus.FORBIDDEN);
      }     
    }
}
