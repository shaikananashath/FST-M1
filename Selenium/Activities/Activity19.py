from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, timeout=10)

    driver.get("https://training-support.net/webelements/alerts")

    print("Page title is:", driver.title)

    driver.find_element(By.ID, "confirmation").click()

    confirm_alert = wait.until(EC.alert_is_present())

    print("Text in alert:", confirm_alert.text)

    confirm_alert.accept()

    print(
        "Result after OK:",
        driver.find_element(By.ID, "result").text
    )

    driver.find_element(By.ID, "confirmation").click()

    confirm_alert = wait.until(EC.alert_is_present())

    print("Text in alert:", confirm_alert.text)

    confirm_alert.dismiss()

    print(
        "Result after Cancel:",
        driver.find_element(By.ID, "result").text
    )