ALTER TABLE vacancies
    ADD COLUMN is_on_instagram boolean not null default false,
    ADD COLUMN is_on_telegram BOOLEAN NOT NULL DEFAULT FALSE,
    ADD COLUMN is_on_jobkg BOOLEAN NOT NULL DEFAULT FALSE,
    ADD COLUMN is_on_facebook BOOLEAN NOT NULL DEFAULT FALSE,
    ADD COLUMN is_on_diesel BOOLEAN NOT NULL DEFAULT FALSE;