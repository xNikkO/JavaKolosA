# MariaDB - Instrukcja Uruchomienia

Ten projekt zawiera instrukcje dotyczące uruchomienia kontenera MariaDB za pomocą Dockera. Poniżej znajdziesz wszystkie niezbędne kroki do uruchomienia bazy danych z własnymi ustawieniami użytkownika, hasła oraz nazwy bazy danych.

---

## Wymagania wstępne

- Zainstalowany Docker. Instrukcję instalacji znajdziesz na stronie [Docker](https://www.docker.com/).

---

## Uruchomienie MariaDB

### 1. Pobierz obraz MariaDB

Uruchom poniższą komendę, aby pobrać oficjalny obraz MariaDB:

```bash
docker pull mariadb
```

---

### 2. Uruchom kontener MariaDB

Uruchom kontener za pomocą poniższej komendy, dostosowując ustawienia według swoich potrzeb:

```bash
docker run -d \
  --name mariadb-container \
  -e MARIADB_ROOT_PASSWORD=twojeHaslo \
  -e MARIADB_DATABASE=twojaBazaDanych \
  -e MARIADB_USER=twojUzytkownik \
  -e MARIADB_PASSWORD=hasloDlaUzytkownika \
  -p 3306:3306 \
  mariadb
```

#### Przykład:
```bash
docker run -d \
  --name mariadb-container \
  -e MARIADB_ROOT_PASSWORD=superHaslo \
  -e MARIADB_DATABASE=mojaBaza \
  -e MARIADB_USER=uzytkownikTestowy \
  -e MARIADB_PASSWORD=mocneHaslo \
  -p 3306:3306 \
  mariadb
```

---

### 3. Sprawdź działanie kontenera

Użyj poniższego polecenia, aby sprawdzić, czy kontener działa:

```bash
docker ps
```

---

## Zatrzymywanie i usuwanie kontenera

### Zatrzymanie kontenera:
```bash
docker stop mariadb-container
```

### Usunięcie kontenera:
```bash
docker rm mariadb-container
```

---

## Połączenie z bazą danych

Aby połączyć się z bazą danych, możesz użyć dowolnego klienta MySQL/MariaDB (np. MySQL Workbench, phpMyAdmin, narzędzia CLI `mysql`) lub polecenia:

### Połączenie z użytkownikiem `root`:
- Host: `localhost`
- Port: `3306`
- Użytkownik: `root`
- Hasło: ustawione w `MARIADB_ROOT_PASSWORD`

### Połączenie z nowo utworzonym użytkownikiem:
- Host: `localhost`
- Port: `3306`
- Użytkownik: ustawiony w `MARIADB_USER`
- Hasło: ustawione w `MARIADB_PASSWORD`
- Baza danych: ustawiona w `MARIADB_DATABASE`

---

## Uwagi

- Pamiętaj o zachowaniu bezpieczeństwa danych, szczególnie haseł.
- Upewnij się, że port `3306` nie jest zajęty przez inną aplikację na Twoim komputerze.
- Jeśli chcesz uruchomić wiele instancji MariaDB, zmień nazwę kontenera i/lub używany port.

