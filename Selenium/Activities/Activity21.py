from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, timeout=10)

    driver.get("https://training-support.net/webelements/tabs")

    print("Page title is:", driver.title)

    print("Current tab:", driver.current_window_handle)

    wait.until(
        EC.element_to_be_clickable(
            (By.XPATH, "//button[text()='Open A New Tab']")
        )
    ).click()

    wait.until(EC.number_of_windows_to_be(2))

    print("Currently open windows:", driver.window_handles)

    driver.switch_to.window(driver.window_handles[1])

    wait.until(
        EC.element_to_be_clickable(
            (By.XPATH, "//button[contains(text(), 'Another One')]")
        )
    )

    print("Current tab:", driver.current_window_handle)

    print("New Page title:", driver.title)

    print(
        "New Page message:",
        driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text
    )

    driver.find_element(
        By.XPATH, "//button[contains(text(), 'Another One')]"
    ).click()

    wait.until(EC.number_of_windows_to_be(3))

    print("Currently open windows:", driver.window_handles)

    driver.switch_to.window(driver.window_handles[2])

    print("Current tab:", driver.current_window_handle)

    print("New Page title:", driver.title)

    print(
        "New Page message:",
        driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text
    )