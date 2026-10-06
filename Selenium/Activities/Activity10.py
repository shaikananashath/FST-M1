from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    driver.get("https://training-support.net/webelements/mouse-events")

    print("Page title is:", driver.title)

    cargo_lock = driver.find_element(
        By.XPATH, "//h1[text()='Cargo.lock']"
    )

    cargo_toml = driver.find_element(
        By.XPATH, "//h1[text()='Cargo.toml']"
    )

    src_button = driver.find_element(
        By.XPATH, "//h1[text()='src']"
    )

    target_button = driver.find_element(
        By.XPATH, "//h1[text()='target']"
    )

    actions.click(cargo_lock) \
        .pause(1) \
        .move_to_element(cargo_toml) \
        .pause(5) \
        .click(cargo_toml) \
        .perform()

    action_message = driver.find_element(
        By.ID, "result"
    ).text

    print(action_message)

    actions.double_click(src_button) \
        .pause(3) \
        .context_click(target_button) \
        .pause(3) \
        .perform()

    open_option = driver.find_element(
        By.XPATH, "//div[@id='menu']/div/ul/li[1]"
    )

    actions.click(open_option) \
        .pause(5) \
        .perform()

    action_message = driver.find_element(
        By.ID, "result"
    ).text

    print(action_message)