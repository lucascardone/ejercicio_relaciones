package com.utn.ejercicio_db;

import com.utn.ejercicio_db.entities.*;
import com.utn.ejercicio_db.repositories.*;
import com.utn.ejercicio_db.utils.Estado;
import com.utn.ejercicio_db.utils.Tipo;
import com.utn.ejercicio_db.utils.TipoEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class EjercicioDbApplication {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private RubroRepository rubroRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    public static void main(String[] args) {
        SpringApplication.run(EjercicioDbApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {

            try {
                ArrayList<Producto> productos = new ArrayList<>();

                Factura factura = Factura.builder()
                        .numero(0012)
                        .descuento(0.20)
                        .total(500)
                        .fecha(LocalDateTime.now().toString())
                        .build();
                facturaRepository.save(factura);

                Producto producto = Producto.builder()
                        .denominacion("Lomo completo")
                        .precioVenta(1500.9)
                        .precioCompra(1000.0)
                        .foto("imagen.png")
                        .receta("Ingredientes:[pan, carne, huevo, tomate]")
                        .stockActual(20)
                        .stockMinimo(1)
                        .tiempoEstimadoCocina(20)
                        .tipo(Tipo.MANUFACTURADO)
                        .unidadMedida("gr")
                        .build();
                productoRepository.save(producto);
                productos.add(producto);

                DetallePedido detallePedido = DetallePedido.builder()
                        .producto(producto)
                        .cantidad(1)
                        .subtotal(1500.9)
                        .build();
                detallePedidoRepository.save(detallePedido);

                Rubro rubro = Rubro.builder()
                        .denominacion("Gastronomico")
                        .productos(productos)
                        .build();
                rubroRepository.save(rubro);

                Pedido pedido = Pedido.builder()
                        .fecha(LocalDate.now().toString())
                        .total(1200.32)
                        .tipoEnvio(TipoEnvio.DELIVERY)
                        .estado(Estado.PREPARADO)
                        .horaEstimadaEntrega("15:00")
                        .factura(factura)
                        .build();
                List<Pedido> pedidos = new ArrayList<>();
                pedidos.add(pedido);
                pedidoRepository.save(pedido);

                Usuario usuario = Usuario.builder()
                        .nombre("Lucas")
                        .pedidos(pedidos)
                        .rol("usuario")
                        .password("psw2012")
                        .build();
                usuarioRepository.save(usuario);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}

