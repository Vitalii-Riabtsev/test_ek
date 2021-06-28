CREATE TYPE public.day_of_week AS ENUM (
'MONDAY',
'TUESDAY',
'WEDNESDAY',
'THURSDAY',
'FRIDAY',
'SATURDAY',
'SUNDAY'
);

CREATE TYPE public.meal_type AS ENUM (
'BREAKFAST',
'LUNCH',
'DINNER',
'WORKOUT_SNACK'
);

CREATE TYPE public.nutrition_type AS ENUM (
'CARBOHYDRATES',
'FATS',
'PROTEINS'
);

CREATE TABLE public.customers (
  customer_id bigint NOT NULL,
  first_name character varying(50),
  last_name character varying(50),
  date_birth date
);

CREATE SEQUENCE public.customer_customer_id_seq
AS integer
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.customer_customer_id_seq OWNED BY public.customers.customer_id;

CREATE TABLE public.customer_nutrition (
  id bigint NOT NULL,
  customer_id bigint NOT NULL,
  meal_id integer NOT NULL,
  nutrition_id integer NOT NULL,
  value integer NOT NULL,
  track_date date DEFAULT CURRENT_DATE NOT NULL,
  CONSTRAINT ch_value CHECK (((value >= 0) AND (value <= 10000)))
);

CREATE SEQUENCE public.customer_nutrition_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.customer_nutrition_id_seq OWNED BY public.customer_nutrition.id;

CREATE TABLE public.functional_flag (
  flag_id integer NOT NULL,
  flag_name character varying(50) NOT NULL
);

CREATE TABLE public.iso_dow_week_days (
  day_id integer NOT NULL,
  day_name public.day_of_week NOT NULL
);

CREATE SEQUENCE public.iso_dow_week_days_day_id_seq
AS integer
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.iso_dow_week_days_day_id_seq OWNED BY public.iso_dow_week_days.day_id;

CREATE TABLE public.meal_plan_nutrition (
  id bigint NOT NULL,
  meal_plan_id bigint NOT NULL,
  meal_id bigint NOT NULL,
  nutrition_id integer NOT NULL,
  value integer NOT NULL,
  start_date date DEFAULT CURRENT_DATE NOT NULL,
  CONSTRAINT ch_value CHECK (((value >= 0) AND (value <= 10000)))
);

CREATE SEQUENCE public.meal_plan_nutrition_meal_plan_nutrition_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.meal_plan_nutrition_meal_plan_nutrition_id_seq OWNED BY public.meal_plan_nutrition.id;

CREATE TABLE public.schedule_nutrition (
  id bigint NOT NULL,
  customer_id bigint NOT NULL,
  meal_plan_id bigint NOT NULL,
  day_id integer NOT NULL,
  functional_flag_mask integer DEFAULT 0 NOT NULL,
  start_date date DEFAULT CURRENT_DATE NOT NULL
);

CREATE SEQUENCE public.schedule_nutrition_schedule_nutrition_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE public.schedule_nutrition_schedule_nutrition_id_seq OWNED BY public.schedule_nutrition.id;

CREATE TABLE public.meal_plans (
  meal_plan_id bigint NOT NULL,
  customer_id bigint NOT NULL,
  meal_plan_name character varying(100) NOT NULL
);

CREATE SEQUENCE public.meal_plans_customer_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.meal_plans_customer_id_seq OWNED BY public.meal_plans.customer_id;

CREATE SEQUENCE public.meal_plans_meal_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.meal_plans_meal_id_seq OWNED BY public.meal_plans.meal_plan_id;

CREATE TABLE public.meals (
  meal_id integer NOT NULL,
  meal_type public.meal_type NOT NULL,
  functional_flag_mask integer DEFAULT 0 NOT NULL
);

CREATE SEQUENCE public.meals_meal_id_seq
AS integer
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.meals_meal_id_seq OWNED BY public.meals.meal_id;

CREATE TABLE public.nutrition (
  nutrition_id integer NOT NULL,
  nutrition_type public.nutrition_type NOT NULL
);

CREATE SEQUENCE public.nutrition_nutrition_id_seq
AS integer
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE public.nutrition_nutrition_id_seq OWNED BY public.nutrition.nutrition_id;

ALTER TABLE ONLY public.customer_nutrition ALTER COLUMN id SET DEFAULT nextval('public.customer_nutrition_id_seq'::regclass);

ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customer_customer_id_seq'::regclass);

ALTER TABLE ONLY public.iso_dow_week_days ALTER COLUMN day_id SET DEFAULT nextval('public.iso_dow_week_days_day_id_seq'::regclass);

ALTER TABLE ONLY public.meal_plan_nutrition ALTER COLUMN id SET DEFAULT nextval('public.meal_plan_nutrition_meal_plan_nutrition_id_seq'::regclass);

ALTER TABLE ONLY public.schedule_nutrition ALTER COLUMN id SET DEFAULT nextval('public.schedule_nutrition_schedule_nutrition_id_seq'::regclass);

ALTER TABLE ONLY public.meal_plans ALTER COLUMN meal_plan_id SET DEFAULT nextval('public.meal_plans_meal_id_seq'::regclass);

ALTER TABLE ONLY public.meal_plans ALTER COLUMN customer_id SET DEFAULT nextval('public.meal_plans_customer_id_seq'::regclass);

ALTER TABLE ONLY public.meals ALTER COLUMN meal_id SET DEFAULT nextval('public.meals_meal_id_seq'::regclass);

ALTER TABLE ONLY public.nutrition ALTER COLUMN nutrition_id SET DEFAULT nextval('public.nutrition_nutrition_id_seq'::regclass);

SELECT pg_catalog.setval('public.customer_customer_id_seq', 1, false);

SELECT pg_catalog.setval('public.customer_nutrition_id_seq', 1, false);

SELECT pg_catalog.setval('public.iso_dow_week_days_day_id_seq', 1, false);

SELECT pg_catalog.setval('public.meal_plan_nutrition_meal_plan_nutrition_id_seq', 1, false);

SELECT pg_catalog.setval('public.meal_plans_customer_id_seq', 1, false);

SELECT pg_catalog.setval('public.meal_plans_meal_id_seq', 1, false);

SELECT pg_catalog.setval('public.meals_meal_id_seq', 4, true);

SELECT pg_catalog.setval('public.nutrition_nutrition_id_seq', 1, false);

ALTER TABLE ONLY public.customer_nutrition
  ADD CONSTRAINT customer_nutrition_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.customers
  ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);

ALTER TABLE ONLY public.functional_flag
  ADD CONSTRAINT functional_flag_pkey PRIMARY KEY (flag_id);

ALTER TABLE ONLY public.iso_dow_week_days
  ADD CONSTRAINT iso_dow_week_days_pkey PRIMARY KEY (day_id);

ALTER TABLE ONLY public.meal_plan_nutrition
  ADD CONSTRAINT meal_plan_nutrition_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.schedule_nutrition
  ADD CONSTRAINT schedule_nutrition_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.meal_plans
  ADD CONSTRAINT meal_plans_pkey PRIMARY KEY (meal_plan_id);

ALTER TABLE ONLY public.meals
  ADD CONSTRAINT meals_pkey PRIMARY KEY (meal_id);

ALTER TABLE ONLY public.nutrition
  ADD CONSTRAINT nutrition_pkey PRIMARY KEY (nutrition_id);

ALTER TABLE ONLY public.meal_plans
  ADD CONSTRAINT uq_customer_id_meal_name UNIQUE (customer_id, meal_plan_name);

ALTER TABLE ONLY public.customer_nutrition
  ADD CONSTRAINT uq_customer_nutrition UNIQUE (customer_id, meal_id, nutrition_id, track_date);

ALTER TABLE ONLY public.iso_dow_week_days
  ADD CONSTRAINT uq_day_name UNIQUE (day_name);

ALTER TABLE ONLY public.functional_flag
  ADD CONSTRAINT uq_flag_name UNIQUE (flag_name);

ALTER TABLE ONLY public.meal_plan_nutrition
  ADD CONSTRAINT uq_meal_plan_nutrition UNIQUE (meal_plan_id, meal_id, nutrition_id, start_date);

ALTER TABLE ONLY public.schedule_nutrition
  ADD CONSTRAINT uq_schedule_nutrition UNIQUE (customer_id, day_id, start_date);

ALTER TABLE ONLY public.meals
  ADD CONSTRAINT uq_meal_type UNIQUE (meal_type);

ALTER TABLE ONLY public.nutrition
  ADD CONSTRAINT uq_nutrition_type UNIQUE (nutrition_type);

ALTER TABLE ONLY public.meal_plans
  ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id) ON UPDATE RESTRICT ON DELETE CASCADE NOT VALID;

ALTER TABLE ONLY public.customer_nutrition
  ADD CONSTRAINT fk_customers FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);

ALTER TABLE ONLY public.schedule_nutrition
  ADD CONSTRAINT fk_customers FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);

ALTER TABLE ONLY public.meal_plan_nutrition
  ADD CONSTRAINT fk_meal_plans FOREIGN KEY (meal_plan_id) REFERENCES public.meal_plans(meal_plan_id) ON UPDATE RESTRICT ON DELETE CASCADE NOT VALID;

ALTER TABLE ONLY public.schedule_nutrition
  ADD CONSTRAINT fk_meal_plans FOREIGN KEY (meal_plan_id) REFERENCES public.meal_plans(meal_plan_id) ON UPDATE RESTRICT ON DELETE CASCADE NOT VALID;

ALTER TABLE ONLY public.schedule_nutrition
  ADD CONSTRAINT fk_days FOREIGN KEY (day_id) REFERENCES public.iso_dow_week_days(day_id) ON UPDATE RESTRICT ON DELETE CASCADE NOT VALID;

ALTER TABLE ONLY public.meal_plan_nutrition
  ADD CONSTRAINT fk_meals FOREIGN KEY (meal_id) REFERENCES public.meals(meal_id) ON UPDATE RESTRICT ON DELETE CASCADE NOT VALID;

ALTER TABLE ONLY public.customer_nutrition
  ADD CONSTRAINT fk_meals FOREIGN KEY (meal_id) REFERENCES public.meals(meal_id);

ALTER TABLE ONLY public.meal_plan_nutrition
  ADD CONSTRAINT fk_nutrition FOREIGN KEY (nutrition_id) REFERENCES public.nutrition(nutrition_id) ON UPDATE RESTRICT ON DELETE CASCADE NOT VALID;

ALTER TABLE ONLY public.customer_nutrition
  ADD CONSTRAINT fk_nutrition FOREIGN KEY (nutrition_id) REFERENCES public.nutrition(nutrition_id);
