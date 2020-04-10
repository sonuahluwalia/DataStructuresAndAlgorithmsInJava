package chapter3;

import chapter1.Assert;

public class Matrix {
	protected int height, width; // size of matrix

	protected Vector rows;

	// vector of row vectors
	public Matrix(int h, int w)
	// pre: h >= 0, w >= 0;
	// post: constructs an h row by w column matrix
	{
		height = h; // initialize height and width
		width = w;
		// allocate a vector of rows
		rows = new Vector(height);
		for (int r = 0; r < height; r++) {
			// each row is allocated and filled with nulls
			Vector theRow = new Vector(width);
			rows.add(theRow);
			for (int c = 0; c < width; c++) {
				theRow.add(null);
			}
		}
	}

	public Object get(int row, int col)
	// pre: 0 <= row < height(), 0 <= col < width()
	// post: returns object at (row, col)
	{
		Assert.pre(0 <= row && row < height, "Row in bounds.");
		Assert.pre(0 <= col && col < width, "Col in bounds.");
		Vector theRow = (Vector) rows.get(row);
		return theRow.get(col);
	}

	public void set(int row, int col, Object value)
	// pre: 0 <= row < height(), 0 <= col < width()
	// post: changes location (row, col) to value
	{
		Assert.pre(0 <= row && row < height, "Row in bounds.");
		Assert.pre(0 <= col && col < width, "Col in bounds.");
		Vector theRow = (Vector) rows.get(row);
		theRow.set(col, value);
	}

	public void addRow(int r)
	// pre: 0 <= r < height()
	// post: inserts row of null values to be row r
	{
		Assert.pre(0 <= r && r < width, "Row in bounds.");
		height++;
		Vector theRow = new Vector(width);
		for (int c = 0; c < width; c++) {
			theRow.add(null);
		}
		rows.add(r, theRow);
	}

}
