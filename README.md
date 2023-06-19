## Welcome to the Blood Bank API.

In it, you will be able to navigate between the candidate registration and information balance functions.

The API has two endpoints:

- {baseURL}/api/person/save/
- {baseURL}/api/info/

The first refers to the registration of candidates for the Blood Bank.

The endpoint is prepared to receive an array of objects, following the pattern, with POST method:

```json
[
  {
    "nome": "John Doe",
    "cpf": "001.000.000-00",
    "rg": "00.000.000-1",
    "data_nasc": "01/01/2000",
    "sexo": "Masculino",
    "mae": "Chloe Doe",
    "pai": "Don Doe",
    "email": "john.doe@test.com",
    "cep": "10000-000",
    "endereco": "Test address",
    "numero": 123,
    "bairro": "Test neighborhood",
    "cidade": "Test city",
    "estado": "CE",
    "telefone_fixo": "(85) 1000-0000",
    "celular": "(85) 91100-0000",
    "altura": 1.8,
    "peso": 80,
    "tipo_sanguineo": "O-"
  },
  {
    "nome": "Joana Doe",
    "cpf": "002.000.000-00",
    "rg": "00.000.000-2",
    "data_nasc": "01/01/2000",
    "sexo": "Feminino",
    "mae": "Chloe Doe",
    "pai": "Don Doe",
    "email": "joana.doe@test.com",
    "cep": "10000-000",
    "endereco": "Test address",
    "numero": 123,
    "bairro": "Test neighborhood",
    "cidade": "Test city",
    "estado": "CE",
    "telefone_fixo": "(85) 2000-0000",
    "celular": "(85) 92100-0000",
    "altura": 1.8,
    "peso": 80,
    "tipo_sanguineo": "O-"
  }
]
```

With that, you will receive the `response`:

**HTTP Status 201**
```json
[
    {
        "id": 1802,
        "name": "John Doe",
        "email": "john.doe@test.com",
        "dateOfBirth": "2000-01-01",
        "phone": "(85) 1000-0000",
        "landline": "(85) 1000-0000",
        "address": {
            "id": 1802,
            "zipCode": "10000-000",
            "address": "Test address",
            "number": 123,
            "neighborhood": "Test neighborhood",
            "state": "CE",
            "createdAt": "2023-06-19T22:21:46.014+00:00",
            "updatedAt": "2023-06-19T22:21:46.014+00:00"
        },
        "info": {
            "id": 1802,
            "cpf": "001.000.000-00",
            "rg": "00.000.000-1",
            "gender": "Masculino",
            "motherName": "Chloe Doe",
            "fatherName": "Don Doe",
            "height": 1.8,
            "weight": 80.0,
            "bloodType": "O-"
        },
        "createdAt": "2023-06-19T22:21:45.991+00:00",
        "updatedAt": "2023-06-19T22:21:45.991+00:00",
        "age": 23
    },
    {
        "id": 1803,
        "name": "Joana Doe",
        "email": "joana.doe@test.com",
        "dateOfBirth": "2000-01-01",
        "phone": "(85) 2000-0000",
        "landline": "(85) 2000-0000",
        "address": {
            "id": 1803,
            "zipCode": "10000-000",
            "address": "Test address",
            "number": 123,
            "neighborhood": "Test neighborhood",
            "state": "CE",
            "createdAt": "2023-06-19T22:21:46.028+00:00",
            "updatedAt": "2023-06-19T22:21:46.028+00:00"
        },
        "info": {
            "id": 1803,
            "cpf": "002.000.000-00",
            "rg": "00.000.000-2",
            "gender": "Feminino",
            "motherName": "Chloe Doe",
            "fatherName": "Don Doe",
            "height": 1.8,
            "weight": 80.0,
            "bloodType": "O-"
        },
        "createdAt": "2023-06-19T22:21:46.026+00:00",
        "updatedAt": "2023-06-19T22:21:46.026+00:00",
        "age": 23
    }
]
```

The second refers to the act of obtaining filtered information about candidates.

The endpoint uses the GET method and returns the `response`:

**HTTP Status 200**
```json
{
    "availableDonorsForEachBloodType": [
        {
            "quantity": 2,
            "bloodType": "A+"
        },
        {
            "quantity": 2,
            "bloodType": "A-"
        },
        {
            "quantity": 2,
            "bloodType": "B+"
        },
        {
            "quantity": 2,
            "bloodType": "B-"
        },
        {
            "quantity": 2,
            "bloodType": "AB+"
        },
        {
            "quantity": 2,
            "bloodType": "AB-"
        },
        {
            "quantity": 2,
            "bloodType": "O+"
        },
        {
            "quantity": 2,
            "bloodType": "O-"
        }
    ],
    "averageAgeForEachBloodType": [
        {
            "bloodType": "O-",
            "averageAge": 23.0
        }
    ],
    "percentageOfObeseMenAndWomen": {
        "female": "0.0%",
        "male": "0.0%"
    },
    "personQuantityForEachState": [
        {
            "state": "CE",
            "quantity": 2
        }
    ],
    "averageBMIPerAge": {
        "23 - 23": 24.691358024691358
    }
}
```

- availableDonorsForEachBloodType -> The number of potential donors for each recipient blood type;
- averageAgeForEachBloodType -> Average age for each blood type;
- percentageOfObeseMenAndWomen -> Percentage of obese men and women;
- personQuantityForEachState -> Person quantity for each state;
- averageBMIPerAge -> Average BMI per age.

To run the project, just clone the repository and change the environment variables in `application.properties`.

```properties
spring.jpa.database=MYSQL (change for your database)

spring.datasource.url=jdbc:mysql://localhost:3306/blood-bank-api?createDatabaseIfNotExist=true (database URL, you can change if you want).
spring.datasource.username=root (database connection username)
spring.datasource.password=root (database connection password)
```

With this, you can execute the project easily and quickly. I hope that you enjoyed.
