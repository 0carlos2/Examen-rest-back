package upeu.edu.pe.examen.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

public class PedidoDTO {

    @Data
    public static class Request {
        private Long id;

        @NotNull(message = "El número de mesa es obligatorio")
        @Min(value = 1, message = "El número de mesa debe ser mayor a 0")
        private Integer numeroMesa;

        @NotNull(message = "El ID del cliente es obligatorio")
        private Long clienteId;

        @NotNull(message = "El ID del plato es obligatorio")
        private Long platoId;
    }

    @Data
    public static class Response {
        private Long id;
        private Integer numeroMesa;
        private String nombreCliente;
        private String nombrePlato;
        private Double precioPlato;
        private Long clienteId;
        private Long platoId;
    }
}