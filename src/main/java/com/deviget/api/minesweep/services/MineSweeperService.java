package com.deviget.api.minesweep.services;

import com.deviget.api.minesweep.entities.MineSweeper;
import com.deviget.api.minesweep.exceptions.ExceededGridValuesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wilson.penagos on 18/12/17.
 */


@Service
public class MineSweeperService extends RestService<MineSweeper> {

    MineSweeper mineSweeper;

    @Autowired
    MineSweeperService() {
        super();
    }

    public MineSweeper createMineSweeper(int rows, int columns, int mines) throws ExceededGridValuesException {
        mineSweeper = new MineSweeper(1L, rows, columns, mines);
        return mineSweeper;
    }
}