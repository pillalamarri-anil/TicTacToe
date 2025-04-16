package Model;

import Enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int dimension;
    List<List<Cell>> cells;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Cell getCell(int row, int col) {
        return cells.get(row).get(col);
    }

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = new ArrayList();
        for (int i = 0; i < dimension; i++) {
            this.cells.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++)
                this.cells.get(i).add(new Cell(i, j));
        }
    }

    public void printBoard() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if(cells.get(i).get(j).getState() == CellState.FILLED)
                    System.out.print(cells.get(i).get(j).getPlayer().getSymbol().getSymbol() + "   ");
                else
                    System.out.print("_" + "   ");
            }
            System.out.println();
        }
    }
}
