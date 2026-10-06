from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/selects")

    print("Page title is:", driver.title)

    dropdown = driver.find_element(
        By.CSS_SELECTOR, "select.h-10"
    )

    single_select = Select(dropdown)

    single_select.select_by_visible_text("Two")

    print(
        "Second option:",
        single_select.first_selected_option.text
    )

    single_select.select_by_index(3)

    print(
        "Third option:",
        single_select.first_selected_option.text
    )

    single_select.select_by_value("four")

    print(
        "Fourth option:",
        single_select.first_selected_option.text
    )

    all_options = single_select.options

    print("Options in the dropdown:")

    for option in all_options:
        print(option.text)