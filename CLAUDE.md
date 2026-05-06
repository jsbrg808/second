# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

```bash
# Build WAR
mvn install

# Run on embedded Tomcat 7 (port 80, context path /)
mvn tomcat7:run

# Build without tests (tests are skipped by default in pom.xml)
mvn package
```

## Architecture

This is a **Korean eGovFramework (전자정부 표준프레임워크) 3.6.0** web application using Spring MVC 4.1.2, iBatis-based DAOs, and MariaDB.

### Layer flow

```
PogoController / CoinController
    → PogoService / CoinService (interface)
        → PogoServiceImpl / CoinServiceImpl (@Service)
            → XxxDAO extends EgovAbstractDAO (@Repository)
                → SQL statements in *_SQL.xml (iBatis sqlMap format)
```

### Key conventions

- **URL pattern**: all requests end in `.do` (e.g. `/selectPogo5fList.do`)
- **DAO query IDs**: `{daoName}.{action}` — e.g. `pogo5fDAO.list`, `pogo5fDAO.append`
- **SQL files** use iBatis 2.x `<sqlMap>` DTD (not MyBatis mapper XML). All SQL maps are registered in `src/main/resources/egovframework/sqlmap/example/sql-map-config.xml`.
- **View resolution**: controller returns a string like `"pogo/pogo5fList"` which resolves to `/WEB-INF/jsp/egovframework/example/pogo/pogo5fList.jsp`
- **Seq shifting pattern**: insert at position uses `updateInc` (shift up) before insert; delete uses `updateDec` (shift down) after delete — to maintain a contiguous `SN` sequence.
- **Search prefix**: search term prefixed with `+` triggers `listByBasNm` (searches by evolutionary base form); without `+` uses `listByNm` (prefix match on name).

### Spring configuration files

| File | Purpose |
|---|---|
| `context-datasource.xml` | MariaDB connection (`localhost:3306/test`, scott/tiger) |
| `context-mapper.xml` | SqlSessionFactoryBean wiring (iBatis sqlMap config) |
| `context-transaction.xml` | Transaction manager |
| `context-aspect.xml` | AOP aspects |
| `dispatcher-servlet.xml` | Spring MVC: component scan, view resolver, exception mapping, pagination |

### Modules

- **pogo**: Pokemon GO data management. Three editable lists (`pogo5f`, `pogo5s`, `pogo5t`) sharing `Pogo5VO`. Read-only views: `pogo5de2`, `pogo5yn`. Complex combined report: `pogo5pc2` (Excel download via Apache POI at `/downloadPogo5pc2.do`).
- **coin**: Coin/code management with `CoinVO` and `CodeVO`.

### Adding a new SQL query

1. Add the `<select|insert|update|delete>` statement to the appropriate `*_SQL.xml` with id `{daoName}.{action}`
2. Add a method to the DAO calling `list(...)`, `insert(...)`, `update(...)`, or `delete(...)` from `EgovAbstractDAO`
3. Add to the `PogoService` interface and implement in `PogoServiceImpl`
4. Call from the controller and return the view name string
