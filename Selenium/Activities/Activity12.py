from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    driver.get("https://training-support.net/webelements/drag-drop")

    print("Page title is:", driver.title)

    football = driver.find_element(By.ID, "ball")
    dropzone1 = driver.find_element(By.ID, "dropzone1")
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    actions.click_and_hold(football) \
        .move_to_element(dropzone1) \
        .pause(5) \
        .release() \
        .perform()

    if dropzone1.find_element(
        By.CLASS_NAME, "dropzone-text"
    ).text == "Dropped!":
        print("Ball was dropped in Dropzone 1")

    actions.drag_and_drop(
        football, dropzone2
    ).pause(5).perform()

    if dropzone2.find_element(
        By.CLASS_NAME, "dropzone-text"
    ).text == "Dropped!":
        print("Ball was dropped in Dropzone 2")