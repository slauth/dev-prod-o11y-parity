all: clean build

clean:
	rm -f slides.html

build:
	docker run -u $$(id -u):$$(id -g) -v $$(pwd):/documents/ asciidoctor/docker-asciidoctor:1 asciidoctor-revealjs slides.adoc

open:
	x-www-browser http://localhost/slides.html

open-grafana:
	x-www-browser http://localhost:3000

open-pdf-print:
	x-www-browser http://localhost/slides.html?print-pdf
