package Mingeso.ProjectMilkStgo;


import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.repositories.ProveedorRepository;
import Mingeso.ProjectMilkStgo.services.ProveedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProveedorServiceTest {
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private ProveedorRepository proveedorRepository;
    private ProveedorEntity proveedorEntity;

    @Test
    void guardarProveedor(){
        proveedorEntity = new ProveedorEntity();
        proveedorEntity.setProveedor_id("00101");
        proveedorEntity.setCategoria("A");
        proveedorEntity.setNombre("Anonimo");
        proveedorEntity.setAfecto_retencion("No");
        proveedorService.guardarProveedor(proveedorEntity);

        assertNotNull(proveedorRepository.encontrarPorCodigo("00101"));

        proveedorRepository.deleteById(proveedorEntity.getProveedor_id());
    }

    @Test
    void obtenerProveedores(){
        assertNotNull(proveedorService.obtenerProveedores());
    }

    @Test
    void obtenerCategoria(){
        proveedorEntity = new ProveedorEntity();
        proveedorEntity.setProveedor_id("00101");
        proveedorEntity.setCategoria("A");
        proveedorEntity.setNombre("Anonimo");
        proveedorEntity.setAfecto_retencion("No");
        proveedorService.guardarProveedor(proveedorEntity);

        assertThat(proveedorService.obtenerCategoria("00101")).isEqualTo("A");

        proveedorRepository.deleteById(proveedorEntity.getProveedor_id());
    }

    @Test
    void encontrarPorCodigo(){
        proveedorEntity = new ProveedorEntity();
        proveedorEntity.setProveedor_id("00101");
        proveedorEntity.setCategoria("A");
        proveedorEntity.setNombre("Anonimo");
        proveedorEntity.setAfecto_retencion("No");
        proveedorService.guardarProveedor(proveedorEntity);

        assertThat(proveedorService.encontrarPorCodigo("00101")).isEqualTo(proveedorEntity);

        proveedorRepository.deleteById(proveedorEntity.getProveedor_id());
    }


}
