CREATE TABLE "user" (
	"id" serial NOT NULL,
	"login" varchar(30) NOT NULL UNIQUE,
	"password" varchar(60) NOT NULL,
	"role" varchar(30) NOT NULL,
	"name" varchar(30) NOT NULL,
	"surname" varchar(30) NOT NULL,
	"city" varchar(30) NOT NULL,
	"phone_number" varchar(30) NOT NULL,
	CONSTRAINT User_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "apartment" (
	"id" serial NOT NULL,
	"number" integer NOT NULL,
	"gas" BOOLEAN NOT NULL,
	"water" BOOLEAN NOT NULL,
	"electricity" BOOLEAN NOT NULL,
	CONSTRAINT Apartment_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "property" (
	"id" serial NOT NULL,
	"apartment_id" integer NOT NULL,
	"user_id" integer NOT NULL,
	CONSTRAINT property_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "ticket" (
	"id" serial NOT NULL,
	"message" TEXT NOT NULL,
	"theme" TEXT NOT NULL,
	"status_id" integer NOT NULL,
	CONSTRAINT Ticket_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "user_ticket" (
	"user_id" integer NOT NULL,
	"ticket_id" integer NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "bill" (
	"id" serial NOT NULL,
	"apartment_id" integer NOT NULL,
	"gas" FLOAT NOT NULL,
	"cold water" FLOAT NOT NULL,
	"hot water" FLOAT NOT NULL,
	"electricity" FLOAT NOT NULL,
	"debt" FLOAT NOT NULL,
	CONSTRAINT bill_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "counter" (
	"id" serial NOT NULL,
	"apartment_id" integer NOT NULL,
	"gas" integer NOT NULL,
	"water" integer NOT NULL,
	"electricity" integer NOT NULL,
	CONSTRAINT Counter_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "apartment_house" (
	"id" serial NOT NULL,
	"city" varchar(40) NOT NULL,
	"street" varchar(40) NOT NULL,
	"number" integer NOT NULL,
	"garbage removal" BOOLEAN NOT NULL DEFAULT 'false',
	"yardman" BOOLEAN NOT NULL DEFAULT 'false',
	"concierge" BOOLEAN NOT NULL DEFAULT 'false',
	"wet cleaning" BOOLEAN NOT NULL DEFAULT 'false',
	CONSTRAINT Apartment_house_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "house_apartments" (
	"id" serial NOT NULL,
	"house_id" integer NOT NULL,
	"apartment_id" integer NOT NULL,
	CONSTRAINT House_apartments_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "property" ADD CONSTRAINT "property_fk0" FOREIGN KEY ("apartment_id") REFERENCES "Apartment"("id");
ALTER TABLE "property" ADD CONSTRAINT "property_fk1" FOREIGN KEY ("user_id") REFERENCES "user"("id");

ALTER TABLE "user_ticket" ADD CONSTRAINT "User_ticket_fk0" FOREIGN KEY ("user_id") REFERENCES "user"("id");
ALTER TABLE "user_ticket" ADD CONSTRAINT "User_ticket_fk1" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");

ALTER TABLE "bill" ADD CONSTRAINT "bill_fk0" FOREIGN KEY ("apartment_id") REFERENCES "Apartment"("id");

ALTER TABLE "counter" ADD CONSTRAINT "Counter_fk0" FOREIGN KEY ("apartment_id") REFERENCES "Apartment"("id");

ALTER TABLE "house_apartments" ADD CONSTRAINT "House_apartments_fk0" FOREIGN KEY ("house_id") REFERENCES Apartments_house("id");
ALTER TABLE "house_apartments" ADD CONSTRAINT "House_apartments_fk1" FOREIGN KEY ("apartment_id") REFERENCES "Apartment"("id");

