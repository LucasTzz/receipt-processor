# Receipt Processor

## Table of Contents
- [Description](#description)
- [API Spec](#api-spec)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Code Structure](#code-structure)

## Description
This is a webservice that processes receipts and calculate award points for them.
It provides two API endpoints: 1. Process Receipts; 2. Get Points.
## API Spec
### Process Receipts
- Path: /receipts/process
- Method: POST
- Payload: Receipt JSON
- Response: JSON containing an id for the receipt.
### Get Points
- Path: /receipts/{id}/points
- Method: GET
- Response: A JSON object containing the number of points awarded.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/LucasTzz/receipt-processor.git
    ```
2. Navigate to the directory:
    ```bash
    cd receipt-processor
    ```
3. Build the Docker Image:
    ```bash
   docker build -t receipt-processor-app .
    ```
4. Run the Docker Container
    ```bash
    docker run -it -p 8080:8080 receipt-processor-app
    ```

## Usage
Once the app is running, send requests to http://localhost:8080 to use the webservice.
### Process Receipt
Sample Request:
```bash
curl --location 'localhost:8080/receipts/process' \
--header 'Content-Type: application/json' \
--data '{
  "retailer": "M&M Corner Market",
  "purchaseDate": "2022-03-20",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    }
  ],
  "total": "9.00"
}'
```
Sample Response:
```json
{
    "id": "5d58cbca-9ef8-4f38-8884-0c85fc6d73bf"
}
```
### Get Points
Sample Request
```bash
curl --location 'localhost:8080/receipts/5d58cbca-9ef8-4f38-8884-0c85fc6d73bf/points'
```
Sample Response
```json
{
    "points": 109
}
```

## Technologies Used
- Java
- SpringBoot
- Java Persistence API

## Code Structure
This project follows a modular structure for clarity and maintainability. 
Below is an overview of the main directories and their purposes:
```text
receipt-processor/
├── src/                      # Main source code directory
│   ├── main/
│   │   ├── java/receipt/     # Application Java code
│   │   │   ├── controller/   # REST API controllers
│   │   │   ├── dto/          # Data Transfer Objects (DTOs) for request/response
│   │   │   ├── entity/       # Database entity classes
│   │   │   ├── service/      # Business logic and service layer
│   │   │   ├── util/         # Utility classes for common functionality
│   │   └── resources/        # Application resources (e.g., properties, empty for now)
├── pom.xml                   # Maven configuration file
├── README.md                 # Project documentation
```