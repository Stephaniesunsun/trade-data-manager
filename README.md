# Trade Data Manager

![Java](https://img.shields.io/badge/Java-17+-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-green) ![License](https://img.shields.io/badge/License-MIT-yellow)

## Features
- Process XML trade data
- H2 database storage
- REST API endpoints
- Kafka event streaming (optional)
- JAXB XML handling

## Quick Start

### Prerequisites
- Java 17+
- Maven 3.8+

### Installation
```bash
git clone https://github.com/Stephaniesunsun/trade-data-manager.git
cd trade-data-manager
mvn clean install
```

### API documentation
- GET /api/trades: Retrieve all trades
- GET /api/trades/{id}: Retrieve a specific trade by ID

### Database
Access H2 Console at: http://localhost:8080/h2-console

- Connection Details: JDBC URL: jdbc:h2:mem:tradedb

- Username: sa

- Password: (leave empty)
## Workflow
1. XML trade data simulates the inbound data from Kafka topic
2. Application process trade data according to the pre-defined schema
3. Load(save) the trade into database (using file based database for POC)

## Key Benefits

### 1. **Apache Camel Integration**
- **Seamless ETL Pipelines**: Camel routes simplify XML trade data ingestion, transformation, and loading
- **Enterprise Integration**:
    - Connect to multiple data sources (FTP, JMS, Kafka) with minimal code
    - Built-in error handling and retry mechanisms
- **Real-time Processing**: Camel-Kafka combo enables event-driven trade processing
- **250+ Components**: Ready-to-use connectors for databases, APIs, and messaging systems

### 2. Unified Trade Processing
- **End-to-end solution** from XML ingestion to database storage
- **Standardized validation** against XSD schemas
- **Audit-ready** with complete transaction records

### 3. Developer Efficiency
- **Spring Boot + Camel** reduces boilerplate code
- **Auto-configured endpoints** (REST, Kafka, Database)
- **Hot-reload** during development

### 4. Enterprise Ready
- **Container-friendly** (Docker/Kubernetes)
- **Metrics & Monitoring**:
    - Camel route metrics
    - Spring Boot Actuator endpoints
- **Scalable architecture** through Camel parallel processing

### 5. Flexible Deployment
```bash
# Run as traditional Spring Boot app
mvn spring-boot:run

# Or deploy as Camel-Karaf bundle (OSGi)
mvn install -Pdeploy