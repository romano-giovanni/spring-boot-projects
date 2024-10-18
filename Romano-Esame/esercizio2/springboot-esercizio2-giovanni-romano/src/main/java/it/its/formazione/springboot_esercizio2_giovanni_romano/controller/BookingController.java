package it.its.formazione.springboot_esercizio2_giovanni_romano.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springboot_esercizio2_giovanni_romano.server.api.BookingsApi;
import it.its.formazione.springboot_esercizio2_giovanni_romano.server.model.BookingDTO;
import it.its.formazione.springboot_esercizio2_giovanni_romano.service.BookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController implements BookingsApi {

    Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    BookingService service;

    @Override
    public ResponseEntity<BookingDTO> createBooking(
            @Parameter(name = "BookingDTO", description = "", required = true) @Valid @RequestBody BookingDTO bookingDTO
    ) {
        logger.info("Entrata nel metodo createBooking con il parametro: {}", bookingDTO);
        BookingDTO result = service.save(bookingDTO);
        logger.info("Uscita dal metodo createBooking con il risultato: {}", result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteBooking(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        logger.info("Entrata nel metodo deleteBooking con l'ID: {}", id);
        if (service.getById(id) != null) {
            service.deleteById(id);
            logger.info("Uscita dal metodo deleteBooking con l'ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.info("Uscita dal metodo deleteBooking: ID {} non trovato", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        logger.info("Entrata nel metodo getAllBookings");
        List<BookingDTO> result = service.getAll();
        logger.info("Uscita dal metodo getAllBookings: restituiti {} elementi", result.size());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookingDTO> getBookingById(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        logger.info("Entrata nel metodo getBookingById con l'ID: {}", id);
        BookingDTO result = service.getById(id);
        if (result != null) {
            logger.info("Uscita dal metodo getBookingById con l'ID: {}", id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        logger.info("Uscita dal metodo getBookingById: booking con l'ID {} non trovato", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<BookingDTO> updateBooking(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "BookingDTO", description = "", required = true) @Valid @RequestBody BookingDTO bookingDTO
    ) {
        logger.info("Entrata nel metodo updateBooking con l'ID: {} e il parametro: {}", id, bookingDTO);
        BookingDTO result = service.update(id, bookingDTO);
        logger.info("Uscita dal metodo updateBooking: aggiornato booking con l'ID {} con i nuovi dati", id);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
