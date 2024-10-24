
-- People
INSERT INTO person (last_name, first_name, birth_name, mother_name, gender, nationality,
                    address_postal_code, address_city, address_street,
                    mailing_address_postal_code, mailing_address_city, mailing_address_street,
                    residence_postal_code, residence_city, residence_street,
                    phone_number, tax_id, notes)
VALUES ('Szabó', 'Anna', 'Szabó Anna', 'Kovács Piroska', 'Female', 'Hungarian',
        '1011', 'Budapest', 'Fő utca',
        '1011', 'Budapest', 'Fő utca',
        '1011', 'Budapest', 'Fő utca',
        '+36-30-1234567', '1234567890',
        'Anna has a preference for communication over phone calls. She is available for meetings in the mornings and prefers remote work due to her location.'),

       ('Kiss', 'Péter', 'Kiss Péter', 'Nagy Katalin', 'Male', 'Hungarian',
        '9022', 'Győr', 'Árpád út',
        '9022', 'Győr', 'Árpád út',
        '9022', 'Győr', 'Árpád út',
        '+36-70-9876543', '0987654321',
        'Prefers written communication, available in the afternoons.'),

       ('Nagy', 'János', 'Nagy János', 'Szabó Erzsébet', 'Male', 'Hungarian',
        '6000', 'Kecskemét', 'Petőfi Sándor utca',
        '6000', 'Kecskemét', 'Petőfi Sándor utca',
        '6000', 'Kecskemét', 'Petőfi Sándor utca',
        '+36-20-1122334', '2345678901',
        'János is open for meetings on Fridays and prefers face-to-face discussions.'),

       ('Tóth', 'Zsuzsa', 'Tóth Zsuzsa', 'Tóth Ilona', 'Female', 'Hungarian',
        '2100', 'Gödöllő', 'Szabadság tér',
        '2100', 'Gödöllő', 'Szabadság tér',
        '2100', 'Gödöllő', 'Szabadság tér',
        '+36-30-8765432', '3456789012',
        'Zsuzsa is flexible with her meeting times and prefers early mornings.'),

       ('Varga', 'István', 'Varga István', 'Varga Mária', 'Male', 'Hungarian',
        '7621', 'Pécs', 'Rákóczi út',
        '7621', 'Pécs', 'Rákóczi út',
        '7621', 'Pécs', 'Rákóczi út',
        '+36-70-6655443', '4567890123',
        'István prefers online meetings and can be reached on weekdays during working hours.');
