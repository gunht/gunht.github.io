package com.example.spring_02.respository;

import com.example.spring_02.model.Book;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookDao extends DAO<Book>{
    public BookDao(String csvFile) {
        this.readCSV(csvFile);
    }

    @Override
    public List<Book> getAll() {
        return collections;
    }

    @Override
    public Optional<Book> get(int id) {
        return collections.stream().filter(u -> u.getId() == id).findFirst();
    }

    @SneakyThrows
    @Override
    public void readCSV(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator('|');//nêu ngăn bằng "," thì bỏ đoạn .withColumnSeparator('|')
            ObjectReader objectReader = mapper.readerFor(Book.class).with(schema);
            Reader reader = new FileReader(file);
            MappingIterator<Book> store = objectReader.readValues(reader);

            while (store.hasNext()) {
                Book book = store.next();
                this.add(book);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void add(Book book) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Book lastBook = collections.get(collections.size() - 1);
            id = lastBook.getId() + 1;
        }
        book.setId(id);
        collections.add(book);
    }

    @Override
    public void update(Book book) {
        get(book.getId()).ifPresent(existBook -> {
            existBook.setName(book.getName());
            existBook.setAuthor(book.getAuthor());
            existBook.setDescription(book.getDescription());
            existBook.setImg(book.getImg());
        });
    }

    @Override
    public void delete(Book book) {
        deleteByID(book.getId());
    }

    @Override
    public void deleteByID(int id) {
        get(id).ifPresent(existBook -> collections.remove(existBook));
    }

    @Override
    public List<Book> searchByKeywork(String keywork) {
        return collections.stream().filter(book -> book.matchWithKeywork(keywork)).collect(Collectors.toList());
    }

}
