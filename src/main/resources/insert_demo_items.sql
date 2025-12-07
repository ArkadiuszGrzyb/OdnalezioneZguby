INSERT INTO public.item (
    additional_info,
    found_date,
    found_place,
    item_color,
    location,
    name,
    notification_date,
    warehouse_place,
    id
) VALUES
      (
          'demo Leather wallet with 3 card slots',
          DATE '2025-12-06',
          'Main Square bench',
          'Black',
          'Krakow',
          'demo Wallet',
          DATE '2025-12-07',
          'Shelf A3',
          nextval('public.item_seq')
      ),
      (
          'demo Blue umbrella, slightly torn',
          DATE '2025-11-20',
          'Bus stop near Galeria Krakowska',
          'Blue',
          'Krakow',
          'Umbrella demo',
          DATE '2025-11-21',
          'Shelf B1',
          nextval('public.item_seq')
      ),
      (
          'iPhone 13 with cracked screen demo',
          DATE '2025-10-15',
          'Cinema lobby',
          'Silver',
          'Krakow',
          'Phone',
          DATE '2025-10-16',
          'Locker C2',
          nextval('public.item_seq')
      ),
      (
          'Keys with red demo keychain',
          DATE '2025-09-01',
          'University library desk',
          'Metal',
          'Krakow',
          'Keys',
          DATE '2025-09-02',
          'Drawer D4',
          nextval('public.item_seq')
      ),
      (
          'demo Black backpack with laptop compartment',
          DATE '2025-08-12',
          'Train station platform',
          'Black',
          'Krakow',
          'Backpack demo',
          DATE '2025-08-13',
          'Shelf E5',
          nextval('public.item_seq')
      ),
      (
          'Gold ring with engraving',
          DATE '2025-07-07',
          'Church entrance',
          'Gold',
          'Krakow',
          'demo Ring',
          DATE '2025-07-08',
          'Safe F6',
          nextval('public.item_seq')
      ),
      (
          'demo Pair of sunglasses, Ray-Ban',
          DATE '2025-06-18',
          'Park fountain',
          'Brown',
          'Krakow',
          'Sunglasses',
          DATE '2025-06-19',
          'Shelf G7',
          nextval('public.item_seq')
      ),
      (
          'Red bicycle helmet',
          DATE '2025-05-25',
          'Bike rack near dormitory',
          'Red',
          'Krakow',
          'Helmet',
          DATE '2025-05-26',
          'Shelf H8',
          nextval('public.item_seq')
      ),
      (
          'Silver bracelet with charms',
          DATE '2025-04-10',
          'Shopping mall restroom',
          'Silver',
          'Krakow',
          'Bracelet',
          DATE '2025-04-11',
          'Locker I9',
          nextval('public.item_seq')
      ),
      (
          'Green notebook with math notes',
          DATE '2025-03-03',
          'High school classroom',
          'Green',
          'Krakow',
          'Notebook',
          DATE '2025-03-04',
          'Shelf J10',
          nextval('public.item_seq')
      );