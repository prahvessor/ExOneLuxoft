# Implement console application(mandatory)
- Read txt file and split it by lines
- Calculate statistic for each line: longest word(symbols between 2 spaces), shortest word, line length,
average word length. Unit test are mandatory
- Aggregate these values for all lines from file(unit test)
- Store line and file statistic into DB(with JDBC).

### Added possibility to handle all files in directory and sub-directories(optional)

The console application uses H2 database.
Before launching the program, you should create tables in database. 
To create tables launch 
```
com.luxoft.exone_database_jdbc.dbutils.TableCreator
```