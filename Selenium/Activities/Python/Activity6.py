from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print("Page title is: ", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")
    checkbox.click()
    print("Checkbox is visible: ", checkbox.is_selected())
    checkbox.click()
    print("Checkbox is visible: ", checkbox.is_selected())