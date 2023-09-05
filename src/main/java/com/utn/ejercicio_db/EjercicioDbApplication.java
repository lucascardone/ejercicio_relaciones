package com.utn.ejercicio_db;

import com.utn.ejercicio_db.entities.Factura;
import com.utn.ejercicio_db.entities.Pedido;
import com.utn.ejercicio_db.entities.Usuario;
import com.utn.ejercicio_db.repositories.*;
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
                Factura factura = Factura.builder()
                        .numero(0012)
                        .descuento(0.20)
                        .total(500)
                        .fecha(LocalDateTime.now().toString())
                        .build();

                Pedido pedido = Pedido.builder()
                        .fecha(LocalDate.now().toString())
                        .total(1200.32)
                        .tipoEnvio("delivery")
                        .estado("en preparacion")
                        .horaEstimadaEntrega("15:00")
                        .factura(factura)
                        .build();
                List<Pedido> pedidos = new ArrayList<>();
                pedidos.add(pedido);

                Usuario usuario = Usuario.builder()
                        .nombre("Lucas")
                        .pedidos(pedidos)
                        .rol("usuario")
                        .password("psw2012")
                        .build();

                // Guardar el objeto en la base de datos
                facturaRepository.save(factura);
                pedidoRepository.save(pedido);
                usuarioRepository.save(usuario);

                try {
                    Optional<Pedido> pedidoRecuperado = pedidoRepository.findById(pedido.getId());
                    if (pedidoRecuperado.isPresent()) {
                        Pedido pedido1 = pedidoRecuperado.get();
                        System.out.println(pedido1.toString());

                    }
                } catch (Exception e) {
                    System.out.println("Error en PEDIDO");
                    System.out.println(e.getMessage());
                }

                try {
                    Optional<Usuario> usuarioRecuperado = usuarioRepository.findById(pedido.getId());
                    if (usuarioRecuperado.isPresent()) {
                        Usuario usuario1 = usuarioRecuperado.get();
                        System.out.println(usuario1.toString());

                    }
                } catch (Exception e) {
                    System.out.println("Error en USUARIO");
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
