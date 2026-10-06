from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, timeout=10)

    driver.get("https://training-support.net/webelements/popups")

    print("Page title is:", driver.title)

    wait.until(
        EC.element_to_be_clickable((By.ID, "launcher"))
    ).click()

    username = wait.until(
        EC.element_to_be_clickable((By.ID, "username"))
    )

    password = driver.find_element(By.ID, "password")

    username.send_keys("admin")
    password.send_keys("password")

    driver.find_element(
        By.XPATH, "//button[text()='Submit']"
    ).click()

    wait.until(
        lambda d: d.find_element(
            By.CSS_SELECTOR, "h2.text-center"
        ).text.strip() != ""
    )

    message = driver.find_element(
        By.CSS_SELECTOR, "h2.text-center"
    ).text

    print("Login message:", message)