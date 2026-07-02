# QKart E-Commerce Platform — QA Automation Suite

## 📖 Overview
Comprehensive automated test suite for **QKart**, a full-featured e-commerce platform. Built as part of the Crio.do QA Automation learning track using Selenium WebDriver, Java, and TestNG.

Validates end-to-end shopping workflows — from user registration and login through product search, cart management, checkout, and order placement.

---

## 🚀 Key Testing Highlights
- **End-to-End Coverage:** Complete user journeys from registration to order placement
- **Page Object Model (POM):** Clean separation of test logic and UI interactions
- **Dynamic Element Handling:** Explicit waits for AJAX-heavy pages
- **Negative Testing:** Invalid login, out-of-stock items, invalid payment inputs
- **Regression Suite:** Modular regression suite for rapid post-deployment validation
- **Data-Driven:** Parameterized scenarios using TestNG DataProvider

---

## 🛠️ Tech Stack
| Technology | Purpose |
|---|---|
| Java | Core language |
| Selenium WebDriver | Browser automation |
| TestNG | Test runner, assertions & grouping |
| Maven | Build & dependency management |
| Page Object Model | Framework architecture |

---

## 📂 Project Structure
```
crio-qkart-ecommerce-qa/
├── src/
│   ├── main/java/pages/
│   │   ├── LoginPage.java
│   │   ├── HomePage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   └── test/java/tests/
│       ├── LoginTest.java
│       ├── SearchTest.java
│       ├── CartTest.java
│       └── CheckoutTest.java
├── test-output/
├── pom.xml
└── README.md
```

---

## ✅ Test Coverage
| Feature | Test Type | Status |
|---|---|---|
| User Registration | Functional | ✅ |
| Login / Logout | Functional | ✅ |
| Product Search | Functional | ✅ |
| Add to Cart | Functional | ✅ |
| Cart Quantity Update | Functional | ✅ |
| Checkout Flow | End-to-End | ✅ |
| Order Placement | End-to-End | ✅ |
| Invalid Login | Negative | ✅ |
| Out-of-Stock Handling | Negative | ✅ |

---

## ▶️ How to Run
```bash
git clone https://github.com/ritvikz/crio-qkart-ecommerce-qa.git
cd crio-qkart-ecommerce-qa
mvn test
```
View reports: Open `test-output/index.html`

---

## 👤 Author
**Ritvik Singh Chouhan** — Senior QA Automation Engineer | SDET-II
🔗 [GitHub](https://github.com/ritvikz) | [Portfolio](https://www.crio.do/learn/portfolio/ritvikchouhan77/) | [LinkedIn](https://www.linkedin.com/in/ritvik-singh-chouhan-8a2a6815a/)
