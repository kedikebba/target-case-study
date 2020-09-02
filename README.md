# Target Case Study

myRetail RESTful service.

## Pre-requisites
MySQL instance should be running with the following credentials
```database
username: target
password: target
```

## Installation

1. Clone the project from [github](https://github.com/kedikebba/target-case-study) to download the RESTful service.
2. Import the project into your IDE preferrably IntelliJ.
3. Run the following maven commands to Install.

  ```maven
   mvn clean install
  ```
4. Populate the database with pre-loaded Product pricing information. Use postman send a GET request to URL.
  ```bash
   localhost:8080/products/saveAll
  ```

## Usage
Use postman to test the following use cases
### GET
```bash
localhost:8080/products/13860428
localhost:8080/products/13860429
```

### PUT
Change the body of the request to contain a new price you want to update to.

```bash
localhost:8080/products/13860428
```
RequestBody
```JSON
{
    "newPrice":555.5
}
```
Check with a new GET request to see the updated value.



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT]()
