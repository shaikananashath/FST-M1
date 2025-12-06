import pandas as pd

data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

df = pd.DataFrame(data)

csv_file = "users.csv"
df.to_csv(csv_file, index=False)
print("CSV file 'users.csv' created successfully.\n")

df_read = pd.read_csv(csv_file)

print("1. Usernames Column:")
print(df_read["Usernames"], "\n")

print("2. Username and Password of Second Row:")
print("Username:", df_read.loc[1, "Usernames"])
print("Password:", df_read.loc[1, "Passwords"], "\n")

print("3. Data sorted by Usernames (Ascending):")
print(df_read.sort_values("Usernames"), "\n")

print("4. Data sorted by Passwords (Descending):")
print(df_read.sort_values("Passwords", ascending=False))