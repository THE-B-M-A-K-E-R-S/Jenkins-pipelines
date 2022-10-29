package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduiServiceMock {

    ProduitRepository produitRepository = Mockito.mock(ProduitRepository.class);

}
