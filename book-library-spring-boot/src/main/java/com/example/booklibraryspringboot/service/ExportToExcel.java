package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.entity.BookEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ExportToExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<BookEntity> listBookEntitys;

    public ExportToExcel(List<BookEntity> listBookEntitys) {
        this.listBookEntitys = listBookEntitys;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("BookEntitys");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "BookEntity ID", style);
        createCell(row, 1, "Book Name", style);
        createCell(row, 2, "Price", style);
        createCell(row, 3, "Publication Year", style);
        createCell(row, 4, "Quantity", style);
        createCell(row, 5, "Rating Average", style);
        createCell(row, 6, "Author Id", style);
        createCell(row, 7, "Category Id", style);
        createCell(row, 8, "Publisher Id", style);


    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer ) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long ) value);
        }
        else {
            cell.setCellValue((String) value);
        }

        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (BookEntity book : listBookEntitys) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, book.getId(), style);
            createCell(row, columnCount++, book.getBookName(), style);
            createCell(row, columnCount++, book.getPrice(), style);
            createCell(row, columnCount++, book.getPublicationYear().toString(), style);
            createCell(row, columnCount++, book.getQuantity(), style);
            createCell(row, columnCount++, book.getRatingAverage(), style);
            createCell(row, columnCount++, book.getAuthor().getId(), style);
            createCell(row, columnCount++, book.getCategory().getId(), style);
            createCell(row, columnCount++, book.getPublisher().getId(), style);




        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
