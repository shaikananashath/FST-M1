from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    
    driver.get("https://training-support.net/webelements/login-form")
    print("Page title is: ", driver.title)

    username = driver.find_element(By.XPATH, "//input[@id='username']")
    password = driver.find_element(By.XPATH, "//input[@id='password']")

    username.send_keys("admin")
    password.send_keys("password")

    login = driver.find_element(By.XPATH, "//button[text()='Submit']")
    login.click()

    message = driver.find_element(By.XPATH, "//h1[contains(@class, 'text-center')]")
    print("Login message: ", message.text)