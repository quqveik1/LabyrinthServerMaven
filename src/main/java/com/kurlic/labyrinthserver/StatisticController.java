package com.kurlic.labyrinthserver;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class StatisticController {
    int amountOfLaunches = 0;

    public static String launchesPath = "savedVariable.txt";

    public StatisticController() {
        readLaunchesFromFile();
    }

    public int getAmountOfLaunches()
    {
        return amountOfLaunches;
    }

    public void setAmountOfLaunches(int amountOfLaunches)
    {
        this.amountOfLaunches = amountOfLaunches;
    }

    @GetMapping("/launch/new")
    public int launch(@RequestParam(value = "name", defaultValue = "NONAME") String name)
    {
        setAmountOfLaunches(getAmountOfLaunches() + 1);
        System.out.println("New launch: " + name);
        return getAmountOfLaunches();
    }
    @GetMapping("/launch/get")
    public int getCLaunch()
    {
        System.out.println("Amount of launches: " + getAmountOfLaunches());
        return getAmountOfLaunches();
    }

    @Scheduled(fixedRate = 10000)
    public void saveVariable() {
        try (FileWriter writer = new FileWriter(launchesPath, false)) {
            writer.write(String.valueOf(amountOfLaunches));
            writer.flush();
            System.out.println("Saved file" + amountOfLaunches);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void readLaunchesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(launchesPath))) {
            String line = reader.readLine();
            setAmountOfLaunches(Integer.parseInt(line));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

}

