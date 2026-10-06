from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title is:", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")

    print("Checkbox is selected:", checkbox.is_selected())

    checkbox.click()

    print("Checkbox is selected:", checkbox.is_selected())