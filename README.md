
# Sertifikasi

## Front End
- Node v16.5
- NuxtJs v2 (Vue 2)
- Axios
- Bootstrap Vue

To Start Front End
```bash
  yarn dev
```

### Features

- Home / Catalog Book 
  - List semua buku berserta deskripsi buku
  - Button untuk meminjam buku
- Dashboard
  - List semua buku dengan status telah terpinjam atau tidak
  - Button untuk mengembalikan buku
- Modal Borrow Book & Return Book
  - Menampilkan nama buku dan deskripsi buku
  - Jika dari page **Home** akan mengampilkan dropdown untuk memilih siapa yang meminjam
  - Jika dari page **Dashboard** akan menghilangkan dropdown
- History
  - List pencatatan peminjaman yang berisikan nama peminjam, nama buku , tanggal       mengembalikan dan tanggal wajib mengembalikan

## Back End
- Spring Boot v3
- Maven 3.8.8
- JDK v17

To Start Back End
```bash
  spring-boot:run
```

## API Reference

### Book

#### Get all books

```http
  GET /api/books
```

| Parameter | Description                |
| :-------- | :------------------------- |
| `none` | Get all list array books |

#### Update Status books

```http
  PUT /api/{id}
```

| Parameter | Description                |
| :-------- | :------------------------- |
| `id` | Update book base on Id |

### List

#### Get all list

```http
  GET /api/list
```

| Parameter | Description   |
| :-------- | :-------------------------------- |
| `none`      | Get all list array history  |

#### Create List History

```http
  POST /api/list
```

| Parameter | Description   |
| :-------- | :-------------------------------- |
| `none`      | To Create new History List  |

### Users

#### Get all users

```http
  GET /api/users
```

| Parameter |Description  |
| :-------- | :---------- |
| `none`      | Get all list array Users |

#### Get user by id

```http
  GET /api/users
```

| Parameter |Description  |
| :-------- | :---------- |
| `id`      | Get user by Id user |

## ERD Diagaram
![ERD](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/erd/erd.png?token=GHSAT0AAAAAACMNBSDCGPF7EVEYNUP4KZAKZM2HQZA)

## Unit Testing

| Skenario | Ekpetasi  |
| :-------- | :---------- |
|  1. Check Home Page List Book | Menampilkan semua list buku beserta apakah dapat di pinjam tidak |
|  2. Check Home Page Update Status Book| Mengecek apakah status buku tersebut sudah terpinjam, dan tercatat di history peminjamannya |
|  3. Check Dashboard Page List Book | Menampilkan semua list buku dan dapat mengembalikan buku |
|  4. Check Dashboard Page Update Status Book | Mengecek apakah status buku tersebut berhasil dikembalikan dan dapat di pinjam lagi |
|  5. Check History Page  | Menampilkan semua list peminjam buku, nama buku dan tanggal pinjam dan tanggal wajib mengembalikan |
|  6. Check Modal Borrow Book Home Page | Menampilkan nama buku, dan deskripsi buku dan siapa yang meminjam buku  |
|  6. Check Modal Borrow Book Dashboard Page | Mengecek apakah satus buku sudah dikembalikan dan dapat di pinjam lagi |

1. ![Home Page](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/unit-testing/home_page.png?token=GHSAT0AAAAAACMNBSDCTZ6MXKUPFS5DAJ5GZM2GTYQ)

2. ![Home Page](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/unit-testing/list_book_borrow.png?token=GHSAT0AAAAAACMNBSDDBX3P2SBG4NQIDYEKZM2HE3Q)

3. ![Dashboard Page](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/unit-testing/dashboard_page.png?token=GHSAT0AAAAAACMNBSDDSFARKRIKFG62CTSOZM2HF6Q)

4. ![Dashboard Page](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/unit-testing/dashboard_borrow.png?token=GHSAT0AAAAAACMNBSDDO7G63ZJNNZBHUHYKZM2HGHQ)

5. ![History Page](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/unit-testing/history.png?token=GHSAT0AAAAAACMNBSDDDZ63UFOALFM3QJCOZM2HGZQ)

6. ![Modal Home Page](https://raw.githubusercontent.com/JonathanTanojo/SertifikasiISB/main/unit-testing/modal_dashboard_page.png?token=GHSAT0AAAAAACMNBSDD2OX3USAIULLOQLFYZM2HIXQ)


