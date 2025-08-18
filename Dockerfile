FROM katalonstudio/katalon:latest

WORKDIR /katalon

COPY . /katalon

ENV KATALON_OPTS=""

CMD katalon-execute.sh
