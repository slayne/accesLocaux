--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-06-06 20:00:26 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12403)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16410)
-- Name: collabo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE collabo (
    id integer NOT NULL,
    idperso integer NOT NULL,
    photo text,
    dateentree timestamp without time zone
);


ALTER TABLE collabo OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16406)
-- Name: collabo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE collabo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE collabo_id_seq OWNER TO postgres;

--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 183
-- Name: collabo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE collabo_id_seq OWNED BY collabo.id;


--
-- TOC entry 184 (class 1259 OID 16408)
-- Name: collabo_idperso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE collabo_idperso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE collabo_idperso_seq OWNER TO postgres;

--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 184
-- Name: collabo_idperso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE collabo_idperso_seq OWNED BY collabo.idperso;


--
-- TOC entry 182 (class 1259 OID 16397)
-- Name: personnel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE personnel (
    id integer NOT NULL,
    nom text,
    prenom text,
    adresse text,
    statut text,
    login text,
    mdp text
);


ALTER TABLE personnel OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16395)
-- Name: personnel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personnel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personnel_id_seq OWNER TO postgres;

--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 181
-- Name: personnel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personnel_id_seq OWNED BY personnel.id;


--
-- TOC entry 2038 (class 2604 OID 16413)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo ALTER COLUMN id SET DEFAULT nextval('collabo_id_seq'::regclass);


--
-- TOC entry 2039 (class 2604 OID 16414)
-- Name: idperso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo ALTER COLUMN idperso SET DEFAULT nextval('collabo_idperso_seq'::regclass);


--
-- TOC entry 2037 (class 2604 OID 16400)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personnel ALTER COLUMN id SET DEFAULT nextval('personnel_id_seq'::regclass);


--
-- TOC entry 2043 (class 2606 OID 16419)
-- Name: collabo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo
    ADD CONSTRAINT collabo_pkey PRIMARY KEY (id);


--
-- TOC entry 2041 (class 2606 OID 16405)
-- Name: personnel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personnel
    ADD CONSTRAINT personnel_pkey PRIMARY KEY (id);


--
-- TOC entry 2044 (class 2606 OID 16420)
-- Name: fk_perso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo
    ADD CONSTRAINT fk_perso FOREIGN KEY (idperso) REFERENCES personnel(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-06 20:00:27 CEST

--
-- PostgreSQL database dump complete
--

