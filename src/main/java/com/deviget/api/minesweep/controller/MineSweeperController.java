package com.deviget.api.minesweep.controller;

import com.deviget.api.minesweep.entities.MineSweeper;
import com.deviget.api.minesweep.exceptions.ExceededGridValuesException;
import com.deviget.api.minesweep.response.Response;
import com.deviget.api.minesweep.response.Result;
import com.deviget.api.minesweep.response.Status;
import com.deviget.api.minesweep.services.MineSweeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wilson.penagos on 18/12/17.
 */

@RestController
@RequestMapping("/minesweeper")
public class MineSweeperController extends BaseRestController<MineSweeper> {

    MineSweeperService mineSweeperService;

    @Autowired
    public MineSweeperController(MineSweeperService service){
        super( service );
        mineSweeperService = service;
    }


    @RequestMapping(method = RequestMethod.POST, params = { "rows", "columns", "mines"})
    public ResponseEntity create(@RequestParam(value="rows") Integer rows,
                                 @RequestParam(value="columns") Integer columns,
                                 @RequestParam(value="mines") Integer mines
    )throws ExceededGridValuesException{
        return new ResponseEntity(
                new Response(
                        new Result(
                                Status.OKAY,
                                "Success"
                        ),
                        mineSweeperService.createMineSweeper(rows, columns, mines)
                ),
                HttpStatus.OK
        );
    }


    @ExceptionHandler(ExceededGridValuesException.class)
    protected ResponseEntity<Response> notFoundExceptionHandler(ExceededGridValuesException e){
        return new ResponseEntity<>(
                new Response(
                        new Result(
                                Status.BAD_REQUEST,
                                e.getMessage()
                        ),
                        null
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}