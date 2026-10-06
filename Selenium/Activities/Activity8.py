from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, 10)

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title is:", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")

    print("Checkbox is visible?", checkbox.is_displayed())

    toggle_button = driver.find_element(
        By.XPATH, "//button[text()='Toggle Checkbox']"
    )

    toggle_button.click()

    wait.until(
        EC.invisibility_of_element_located((By.ID, "checkbox"))
    )

    print("Checkbox is visible? False")

    driver.find_element(
        By.XPATH, "//button[text()='Toggle Checkbox']"
    ).click()

    checkbox = wait.until(
        EC.element_to_be_clickable((By.ID, "checkbox"))
    )

    checkbox.click()

    print("Checkbox is selected?", checkbox.is_selected())