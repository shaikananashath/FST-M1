from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, 10)

    driver.get("https://training-support.net/webelements/tables")

    print("Page title is:", driver.title)

    cols = driver.find_elements(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/thead/tr/th"
    )

    print("Number of columns:", len(cols))

    rows = driver.find_elements(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/tbody/tr"
    )

    print("Number of rows:", len(rows))

    cell_value = driver.find_element(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"
    )

    print("Book name before sorting:", cell_value.text)

    price_header = wait.until(
        EC.element_to_be_clickable(
            (
                By.XPATH,
                "//table[contains(@class, 'table-auto')]/thead/tr/th[5]"
            )
        )
    )

    price_header.click()

    cell_value = wait.until(
        EC.visibility_of_element_located(
            (
                By.XPATH,
                "//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"
            )
        )
    )

    print("Book name after sorting:", cell_value.text)