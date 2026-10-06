from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    driver.get("https://training-support.net/webelements/keyboard-events")

    print("Page title is:", driver.title)

    actions.send_keys(
        "This is coming from Selenium"
    ).send_keys(
        Keys.RETURN
    ).perform()

    page_text = driver.find_element(
        By.CSS_SELECTOR, "h1.mt-3"
    ).text

    print(page_text)