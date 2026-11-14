const url = "/api/champions";
const main = document.querySelector("#champion-container");

async function getChampions()
{
    const response = await fetch(url);

    if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
    }

    return response.json();
}

const champions = await getChampions();

champions.forEach(champion =>
{
    const championCard = document.createElement("div");
    championCard.classList.add("champion-card");

    const img = document.createElement("img");
    img.classList.add("champion-image");

    const header = document.createElement("h2");
    header.classList.add("champion-name");

    header.textContent = champion.name;
    img.src = champion.imageUrl;




    championCard.append(header);
    championCard.append(img);
    championCard.append(createChampionStats(champion));

    main.append(championCard);
})

function createChampionStats(champion)
{
    const statsContainer = document.createElement("div");
    statsContainer.classList.add("champion-stats");


    statsContainer.append(
        createStat("AD", champion.stats.attackDamage),
        createStat("HP", champion.stats.health),
        createStat("Armor", champion.stats.armor),
        createStat("MR", champion.stats.magicResist),
        createStat("AS", champion.stats.attackSpeed),
        createStat("MS", champion.stats.movementSpeed)
    );

    return statsContainer;
}

function createStat(label, value)
{
    const stat = document.createElement("div");
    stat.classList.add("stat");

    const statLabel = document.createElement("span");
    statLabel.textContent = label;

    const statValue = document.createElement("span");
    statValue.textContent = typeof value === "number" && label === "AS"
        ? value.toFixed(2)
        : value;

    stat.append(statLabel, statValue);

    return stat;
}