from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title is:", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")

    print("Checkbox is visible:", checkbox.is_displayed())

    checkbox_toggle = driver.find_element(
        By.XPATH, "//button[text()='Toggle Checkbox']"
    )

    checkbox_toggle.click()

    WebDriverWait(driver, 10).until(
        EC.invisibility_of_element_located((By.ID, "checkbox"))
    )

    print("Checkbox is visible: False")